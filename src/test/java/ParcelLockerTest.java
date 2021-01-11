import org.junit.jupiter.api.Test;
import parcellocker.ParcelLocker;

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

        //then
        assertTrue(parcelLocker.sendParcel(x, y, z, phonenumber, email));
        System.out.println(parcelLocker.getParcelList().get(0));
    }

    @Test
    public void receiveParcelTest()
    {
        //given
        ParcelLocker parcelLocker = new ParcelLocker();
        int x = 35;
        int y = 23;
        int z = 8;
        long phonenumber = 604323123;
        String email = "test@test.pl";

        //when
        parcelLocker.sendParcel(x, y, z, phonenumber, email);
        String code = parcelLocker.getParcelList().get(0).getReceiveCode();
        System.out.println(parcelLocker.receiveParcel(code));
        //then
        assertEquals(parcelLocker.getParcelList().size(),0);
    }

}
