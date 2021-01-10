package parcellocker;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Parcel {

    private int sizeX;
    private int sizeY;
    private int sizeZ;
    private String receiveCode="";
    private Sender sender;
    private ParcelStatus parcelStatus;
    static int iterator =1;
    private int id;

    public Parcel( int sizeX, int sizeY, int sizeZ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
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
