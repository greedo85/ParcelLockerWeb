package parcellocker;

import lombok.Getter;
import lombok.ToString;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter

public class ParcelLocker {

    private static List<Parcel> parcelList;
    private PrintWriter printWriter;
    public static List<Parcel> getParcelList() {
        return parcelList;
    }
    private MessageStatus messageStatus;

    public ParcelLocker() {
        printWriter=new PrintWriter(System.out);
        parcelList = new ArrayList<>();
    }

    public boolean sendParcel(Parcel parcel, Sender sender) {

        if (!(checkDimentions(parcel.getSizeX(), parcel.getSizeY(), parcel.getSizeZ()))) {
            messageStatus = MessageStatus.PACZKA_ZA_DUZA;
        } else if (parcelList.size() > 100) {
           messageStatus = MessageStatus.PACZKOMAT_PELNY;
        }
        else {
            parcel.setSender(sender);
            parcel.setParcelStatus(ParcelStatus.NADANA);
            messageStatus = MessageStatus.POPRAWNIE_NADANA;
            parcelList.add(parcel);
            return true;
        }
        return false;
    }


    public Parcel createParcel(int x, int y, int z) {
    return new Parcel(x,y,z);
}

    public Sender createSender(String name, String surname, long phonenumnber, String email)
    {
        if (!(checkEmail(email))) {
            messageStatus = MessageStatus.BLEDNY_EMAIL;
            return null;
        }else
        return new Sender(name,surname,email,phonenumnber);
    }

    public Parcel receiveParcel( String code ) {
        for (Parcel p : parcelList) {
            if (p.getReceiveCode().equals(code)) {
                p.setParcelStatus(ParcelStatus.ODEBRANA);
                return p;
            }
        }
        return null;
    }

    public boolean checkDimentions( int x, int y, int z ) {
        if (x < 40 && y < 25 && z < 10) {
            return true;
        }
        return false;
    }

    public boolean checkEmail( String email ) {
        Pattern pattern = Pattern.compile("\\w*@\\w*\\.[a-z]*");
        Matcher matcher = pattern.matcher(email);
        boolean isValid = matcher.matches();
        return isValid;
    }

}
