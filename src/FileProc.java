

import java.io.IOException;
<<<<<<< HEAD
=======
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Path;
>>>>>>> b07872d4f42204f21a9a6f5c4e80002ffdb6b8a7
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
=======
import javax.servlet.http.HttpSession;
>>>>>>> b07872d4f42204f21a9a6f5c4e80002ffdb6b8a7
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/FileProc")
@MultipartConfig
public class FileProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(FileProc.class);
	private static final String UPLOAD_DIRECTORY = "D:\\csv\\";

	public FileProc() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
<<<<<<< HEAD
=======
		HttpSession session = request.getSession();
>>>>>>> b07872d4f42204f21a9a6f5c4e80002ffdb6b8a7
		RequestDispatcher rd = null;
		String fileName = "";
		Part filePart = null;
		InvoiceDAO iDao = null;
		List<InvoiceDTO> invoiceList = null;
<<<<<<< HEAD
=======
		List<InvoiceDTO> invoiceDetailList = null;
>>>>>>> b07872d4f42204f21a9a6f5c4e80002ffdb6b8a7
		String action = request.getParameter("action");
		
		switch (action) {
		////////////////////////////////////////////////////////////////////////////
		case "fileUpload": //
			LOG.trace("fileUpload 시작");
			
			//description = request.getParameter("description"); // Retrieves <input type="text" name="description">
		    filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
		    fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // 파일 입력받은 거 이름
		   
		    String finalPath = UPLOAD_DIRECTORY + fileName;
		    LOG.trace("fileName - " + finalPath);
		    LOG.trace("finalPath - " + finalPath);
		    FileDAO fDao = new FileDAO();
		    			
		    fDao.insertFileIntoTable(finalPath);
<<<<<<< HEAD
			fDao.orderInvoiceIdSet();
			fDao.orderInvoiceIdUpdate();
			iDao = new InvoiceDAO();
=======
			
			iDao = new InvoiceDAO();

>>>>>>> b07872d4f42204f21a9a6f5c4e80002ffdb6b8a7
			invoiceList = iDao.selectInvoiceAll();
			
			//request.setAttribute("fileName", fileName);
			//request.setAttribute("finalPath", finalPath);
			request.setAttribute("invoiceList", invoiceList);

			rd = request.getRequestDispatcher("view/invoiceProcess.jsp");
			rd.forward(request, response);
			LOG.trace("fileUpload 성공");
			break;
		default:
			LOG.trace("action이 잘못된 값입니다.");

		}
		
	}
	
	

}
