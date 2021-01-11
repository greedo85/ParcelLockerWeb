package parcellocker;

import lombok.Getter;
import lombok.ToString;

import java.io.PipedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@ToString
public class ParcelLocker {

    private static List<Parcel> parcelList;
    private PrintWriter printWriter;
    public static List<Parcel> getParcelList() {
        return parcelList;
    }
    private Status status;
    public ParcelLocker() {
        printWriter=new PrintWriter(System.out);
        parcelList = new ArrayList<>();
    }

    public boolean sendParcel( int sizeX, int sizeY, int sizeZ, long phoneNumber, String email ) {
        Parcel parcel = null;
        if (!(checkDimentions(sizeX, sizeY, sizeZ))) {
            status=Status.PACZKA_ZA_DUZA;
        } else if (parcelList.size() > 100) {
           status=Status.PACZKOMAT_PELNY;
        } else if (!(checkEmail(email))) {
            status=Status.BLEDNY_EMAIL;
        } else {
            parcel = new Parcel(sizeX, sizeY, sizeZ, phoneNumber, email);
            parcelList.add(parcel);
            status=Status.NADANA;
            return true;
        }
        return false;
    }

    public Parcel receiveParcel( String code ) {
        for (Parcel p : parcelList) {
            if (p.getReceiveCode().equals(code)) {
                parcelList.remove(p);
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
