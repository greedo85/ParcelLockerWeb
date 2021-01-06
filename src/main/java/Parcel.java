import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Parcel {

    private int sizeX;
    private int sizeY;
    private int sizeZ;
    private String receiveCode = "";
    private String email;
    private long phoneNumber;
    static int iterator =1;
    private int id;

    public Parcel( int sizeX, int sizeY, int sizeZ, long phoneNumber, String email ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
        this.phoneNumber = phoneNumber;
        this.email = email;
        receiveCode = generateCode();
        id = iterator++;
    }

    public String generateCode() {
        int min = 64;
        int max = 122;
        int number;
        char code;
        for (int i = 0; i < 10; i++) {
            number = min + (int) (Math.random() * ((max - min) + 1));
            code = (char) number;
            receiveCode += code;
        }
        return receiveCode;
    }
}
