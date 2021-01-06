import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class ParcelLocker {

    private static List<Parcel> parcelList;

    public static List<Parcel> getParcelList() {
        return parcelList;
    }

    public ParcelLocker() {
        parcelList = new ArrayList<>();
    }

    public boolean sendParcel( int sizeX, int sizeY, int sizeZ, long phoneNumber, String email ) {
        Parcel parcel = null;
        if (!(checkDimentions(sizeX, sizeY, sizeZ))) {
            System.out.println("Paczka za duża");
        } else if (parcelList.size() > 100) {
            System.out.println("Nie mogę nadać paczki, paczkomat pełny");
        } else if (!(checkEmail(email))) {
            System.out.println("Nieprawidłowy email");
        } else {
            parcel = new Parcel(sizeX, sizeY, sizeZ, phoneNumber, email);
            parcelList.add(parcel);
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
