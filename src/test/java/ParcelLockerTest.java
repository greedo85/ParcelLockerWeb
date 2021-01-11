import org.junit.jupiter.api.Test;
import parcellocker.Parcel;
import parcellocker.ParcelLocker;
import parcellocker.ParcelStatus;
import parcellocker.Sender;

import static org.junit.jupiter.api.Assertions.*;
public class ParcelLockerTest {

    @Test
    public void sendParcelTest() {
        //given
        ParcelLocker parcelLocker = new ParcelLocker();
        int x = 35;
        int y = 23;
        int z = 8;
        long phonenumber = 604323123;
        String email = "test@test.pl";
        Sender sender = new Sender("Adam", "Kowalski", email, phonenumber);
        Parcel parcel = new Parcel(x, y, z);
        //then
        assertTrue(parcelLocker.sendParcel(parcel, sender));
        System.out.println(parcelLocker.getParcelList().get(0));
    }

    @Test
    public void receiveParcelTest() {
        //given
        ParcelLocker parcelLocker = new ParcelLocker();
        int x = 35;
        int y = 23;
        int z = 8;
        long phonenumber = 604323123;
        String email = "test@test.pl";
        Sender sender = new Sender("Adam", "Kowalski", email, phonenumber);
        Parcel parcel = new Parcel(x, y, z);
        //when
        parcelLocker.sendParcel(parcel, sender);
        String code = parcelLocker.getParcelList().get(0).getReceiveCode();
        System.out.println(parcelLocker.receiveParcel(code));
        //then
        assertEquals(parcelLocker.getParcelList().get(0).getParcelStatus(), ParcelStatus.ODEBRANA);
    }

}
