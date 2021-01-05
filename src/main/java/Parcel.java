import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class Parcel {

    private int sizeX;
    private int sizeY;
    private int sizeZ;
    private String receiveCode;
    private String email;
    private long phoneNumber;

    public Parcel( int sizeX, int sizeY, int sizeZ, long phoneNumber ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
        this.phoneNumber = phoneNumber;
        receiveCode = generateCode();
    }

    public void setEmail( String email ) {
        if (checkEmail(email)) {
            this.email = email;
        }
    }

    public boolean checkEmail( String email ) {
        Pattern pattern = Pattern.compile("\\w*@\\w*\\.[a-z]*");
        Matcher matcher = pattern.matcher(email);
        boolean isValid = matcher.matches();
        return isValid;
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
