import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.List;

public class ParcelLocker {

    static List<Parcel> parcelList;

    public ParcelLocker() {
        parcelList=new ArrayList<>();
    }

    public void sendParcel( Parcel parcel )
    {
        if(parcelList.size()<100) {
            parcelList.add(parcel);
        }
        else
            System.out.println("Nie mogę nadać paczki, paczkomat pełny");
    }

    public Parcel receiveParcel(String code)
    {
        for (Parcel p :parcelList) {
            if(p.getReceiveCode().equals(code))
                parcelList.remove(p);
            return p;
        }
        return null;
    }
}
