package servlet;

import parcellocker.Parcel;
import parcellocker.ParcelLocker;
import parcellocker.Sender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/send")
public class SendParcel extends HttpServlet {

    ParcelLocker parcelLocker=new ParcelLocker();
    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        int sizeX = Integer.parseInt(req.getParameter("sizeX"));
        int sizeY = Integer.parseInt(req.getParameter("sizeY"));
        int sizeZ = Integer.parseInt(req.getParameter("sizeZ"));
        String email = req.getParameter("email");
        long phoneNumber = Long.parseLong(req.getParameter("phonenumber"));
        String name=req.getParameter("name");
        String surname=req.getParameter("surname");
        Sender sender=parcelLocker.createSender(name,surname,phoneNumber,email);
        Parcel parcel=parcelLocker.createParcel(sizeX,sizeY,sizeZ);
        parcelLocker.sendParcel(parcel,sender);
        printWriter.println(parcelLocker.getMessageStatus());
        printWriter.println("Kod obioru: "+parcel.getReceiveCode());

    }
}
