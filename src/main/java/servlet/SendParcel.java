package servlet;

import parcellocker.ParcelLocker;

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
        parcelLocker.sendParcel(sizeX,sizeY,sizeZ,phoneNumber,email);
        printWriter.println(parcelLocker.getStatus());
        printWriter.println(parcelLocker.getParcelList());
    }
}
