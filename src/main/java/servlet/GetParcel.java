package servlet;

import parcellocker.ParcelLocker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetParcel extends HttpServlet {

    ParcelLocker parcelLocker = new ParcelLocker();

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws  IOException {
        PrintWriter printWriter = resp.getWriter();
        String receiveCode=req.getParameter("code");
        printWriter.println(parcelLocker.receiveParcel(receiveCode));
    }
}
