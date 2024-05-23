package com.daea.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daea.daos.EquiDao;
import com.daea.dtos.EquiDto;
import com.daea.util.Paging;


@WebServlet("*.board")
public class EquiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("command값:" + command);
		
		EquiDao dao = new EquiDao();
		HttpSession session = request.getSession();
		
		if (command.equals("/boardList.board")) {
			String pnum=request.getParameter("pnum");
			System.out.println("pnum : "+ pnum);
			if(pnum==null) {
				pnum=(String)session.getAttribute("pnum");//현재 조회중인 페이지번호
			}else {
				//새로 페이지를 요청할 경우 세션에 저장
				session.setAttribute("pnum", pnum);
			}
			
			List<EquiDto> list = dao.getAllData(pnum);
			request.setAttribute("list", list);
			
			int pcount=dao.getPCount();
			request.setAttribute("pcount", pcount);
			
			Map<String, Integer> map=Paging.pagingValue(pcount, pnum, 5);
			request.setAttribute("pMap", map);
			
			dispatch("board/boardList.jsp", request, response);
		} else if (command.equals("/insertDataForm.board")) {
			dispatch("board/insertDataForm.jsp", request, response);
		} else if (command.equals("/insertData.board")) {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date IntroductionDate = null;
			try {
				IntroductionDate = dateFormat.parse(request.getParameter("IntroductionDate"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			EquiDto dto = new EquiDto();

			dto.setDepartmentName(request.getParameter("DepartmentName"));
			dto.setOperator(request.getParameter("Operator"));
			dto.setContactInfo(request.getParameter("ContactInfo"));
			dto.setPurpose(request.getParameter("purpose"));
			dto.setModelName(request.getParameter("ModelName"));
			dto.setEquipmentName(request.getParameter("EquipmentName"));
			dto.setIntroductionDate(IntroductionDate);

			dto.setAssetNumber(request.getParameter("AssetNumber"));
			dto.setIP(request.getParameter("IP"));
			dto.setManufacturer(request.getParameter("Manufacturer"));
			dto.setMaintenanceCompany(request.getParameter("MaintenanceCompany"));
			dto.setMaintenanceContact(request.getParameter("MaintenanceContact"));
			dto.setOS(request.getParameter("OS"));
			dto.setDBMS(request.getParameter("DBMS"));
			dto.setCPUVersion(request.getParameter("CPUVersion"));
			dto.setMemoryVersion(request.getParameter("MemoryVersion"));
			dto.setDiskVersion(request.getParameter("DiskVersion"));
			dto.setNWCard(request.getParameter("NWCard"));
			dto.setPowerVersion(request.getParameter("PowerVersion"));
			dto.setSN(request.getParameter("SN"));
			dto.setAntivirus(request.getParameter("Antivirus"));
			dto.setMainProgram(request.getParameter("MainProgram"));
			dto.setSSD(request.getParameter("SSD"));
			dto.setDVDROM(request.getParameter("DVDROM"));
			dto.setHDD(request.getParameter("HDD"));
			dto.setNIC(request.getParameter("NIC"));
			dto.setController(request.getParameter("Controller"));
			dto.setHBA(request.getParameter("HBA"));
			dto.setDrive(request.getParameter("Drive"));
			dto.setCartridge(request.getParameter("Cartridge"));
			dto.setStreamingSolution(request.getParameter("StreamingSolution"));
			dto.setGraphicCard(request.getParameter("GraphicCard"));
			dto.setCluster(request.getParameter("Cluster"));
			dto.setBackupRepository(request.getParameter("BackupRepository"));
			dto.setEtc(request.getParameter("etc"));

			dto.setOS_q(request.getParameter("OS_q"));
			dto.setDBMS_q(request.getParameter("DBMS_q"));
			dto.setCPUVersion_q(request.getParameter("CPUVersion_q"));
			dto.setMemoryVersion_q(request.getParameter("MemoryVersion_q"));
			dto.setDiskVersion_q(request.getParameter("DiskVersion_q"));
			dto.setNWCard_q(request.getParameter("NWCard_q"));
			dto.setPowerVersion_q(request.getParameter("PowerVersion_q"));
			dto.setSN_q(request.getParameter("SN_q"));
			dto.setAntivirus_q(request.getParameter("Antivirus_q"));
			dto.setMainProgram_q(request.getParameter("MainProgram_q"));
			dto.setSSD_q(request.getParameter("SSD_q"));
			dto.setDVDROM_q(request.getParameter("DVDROM_q"));
			dto.setHDD_q(request.getParameter("HDD_q"));
			dto.setNIC_q(request.getParameter("NIC_q"));
			dto.setController_q(request.getParameter("Controller_q"));
			dto.setHBA_q(request.getParameter("HBA_q"));
			dto.setDrive_q(request.getParameter("Drive_q"));
			dto.setCartridge_q(request.getParameter("Cartridge_q"));
			dto.setStreamingSolution_q(request.getParameter("StreamingSolution_q"));
			dto.setGraphicCard_q(request.getParameter("GraphicCard_q"));
			dto.setCluster_q(request.getParameter("Cluster_q"));
			dto.setBackupRepository_q(request.getParameter("BackupRepository_q"));
			dto.setEtc_q(request.getParameter("etc_q"));

			dto.setOS_n(request.getParameter("OS_n"));
			dto.setDBMS_n(request.getParameter("DBMS_n"));
			dto.setCPUVersion_n(request.getParameter("CPUVersion_n"));
			dto.setMemoryVersion_n(request.getParameter("MemoryVersion_n"));
			dto.setDiskVersion_n(request.getParameter("DiskVersion_n"));
			dto.setNWCard_n(request.getParameter("NWCard_n"));
			dto.setPowerVersion_n(request.getParameter("PowerVersion_n"));
			dto.setSN_n(request.getParameter("SN_n"));
			dto.setAntivirus_n(request.getParameter("Antivirus_n"));
			dto.setMainProgram_n(request.getParameter("MainProgram_n"));
			dto.setSSD_n(request.getParameter("SSD_n"));
			dto.setDVDROM_n(request.getParameter("DVDROM_n"));
			dto.setHDD_n(request.getParameter("HDD_n"));
			dto.setNIC_n(request.getParameter("NIC_n"));
			dto.setController_n(request.getParameter("Controller_n"));
			dto.setHBA_n(request.getParameter("HBA_n"));
			dto.setDrive_n(request.getParameter("Drive_n"));
			dto.setCartridge_n(request.getParameter("Cartridge_n"));
			dto.setStreamingSolution_n(request.getParameter("StreamingSolution_n"));
			dto.setGraphicCard_n(request.getParameter("GraphicCard_n"));
			dto.setCluster_n(request.getParameter("Cluster_n"));
			dto.setBackupRepository_n(request.getParameter("BackupRepository_n"));
			dto.setEtc_n(request.getParameter("etc_n"));
			
			if (dao.insertData(dto)) {
				response.sendRedirect("boardList.board");
			} else {
				dispatch("board/insertDataForm.jsp", request, response);
			}
		} else if (command.equals("/searchData.board")) {
			System.out.println("검색 실행");
			String keyword = request.getParameter("keyword");
			System.out.println("전달받은 keyword" + keyword);
			List<EquiDto> list = dao.searchData(keyword);
			request.setAttribute("list", list);
			System.out.println("검색된 리스트"+list);
			dispatch("board/boardList.jsp", request, response);
		} else if (command.equals("/detailData.board")) {
            String assetNumber = request.getParameter("assetNumber");
            System.out.println(assetNumber);
            EquiDto dto = dao.getDetailData(assetNumber);
            request.setAttribute("dto", dto);
            dispatch("board/detailData.jsp", request, response);
        }
	}
	
	public void dispatch(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(url).forward(request, response);
	}



}