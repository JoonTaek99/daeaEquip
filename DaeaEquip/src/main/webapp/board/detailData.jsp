<%@page import="com.daea.dtos.EquiDto"%>
<%@page import="com.daea.daos.EquiDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Data</title>
    <style>
        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        .form-title {
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="form-title">전산장비 정보</h2>
        <form action="insertData.board" method="post">
            <table>
                <tr>
                    <th>부서명</th>
                    <td>${dto.departmentName}</td>
                    <th>운영자</th>
                    <td>${dto.operator}</td>
                    <th>연락처</th>
                    <td>${dto.contactInfo}</td>
                </tr>
                <tr>
                    <th>용도</th>
                    <td>${dto.purpose}</td>
                    <th>모델명</th>
                    <td>${dto.modelName}</td>
                    <th>장비명</th>
                    <td>${dto.equipmentName}</td>
                </tr>
                <tr>
                    <th>도입일자</th>
                    <td>${dto.introductionDate}</td>
                    <th>자산번호</th>
                    <td>${dto.assetNumber}</td>
                    <th>IP</th>
                    <td>${dto.IP}</td>
                </tr>
                <tr>
                    <th>제조업체</th>
                    <td>${dto.manufacturer}</td>
                    <th>유지보수업체</th>
                    <td>${dto.maintenanceCompany}</td>
                    <th>업체연락처</th>
                    <td>${dto.maintenanceContact}</td>
                </tr>
            </table>

            <table>
                <tr>
                    <th>기본항목</th>
                    <th>사양</th>
                    <th>수량</th>
                    <th>비고</th>
                </tr>
                <tr>
                    <td>OS</td>
                    <td><input type="text" name="OS" /></td>
                    <td><input type="number" name="OS_q" /></td>
                    <td><input type="text" name="OS_n" /></td>
                </tr>
                <tr>
                    <td>DBMS</td>
                    <td><input type="text" name="DBMS" /></td>
                    <td><input type="number" name="DBMS_q" /></td>
                    <td><input type="text" name="DBMS_n" /></td>
                </tr>
                <tr>
                    <td>CPU</td>
                    <td><input type="text" name="CPUVersion" /></td>
                    <td><input type="number" name="CPUVersion_q" /></td>
                    <td><input type="text" name="CPUVersion_n" /></td>
                </tr>
                <tr>
                    <td>Memory</td>
                    <td><input type="text" name="MemoryVersion" /></td>
                    <td><input type="number" name="MemoryVersion_q" /></td>
                    <td><input type="text" name="MemoryVersion_n" /></td>
                </tr>
                <tr>
                    <td>Disk</td>
                    <td><input type="text" name="DiskVersion" /></td>
                    <td><input type="number" name="DiskVersion_q" /></td>
                    <td><input type="text" name="DiskVersion_n" /></td>
                </tr>
                <tr>
                    <td>NW Card</td>
                    <td><input type="text" name="NWCard" /></td>
                    <td><input type="number" name="NWCard_q" /></td>
                    <td><input type="text" name="NWCard_n" /></td>
                </tr>
                <tr>
                    <td>Power</td>
                    <td><input type="text" name="PowerVersion" /></td>
                    <td><input type="number" name="PowerVersion_q" /></td>
                    <td><input type="text" name="PowerVersion_n" /></td>
                </tr>
                <tr>
                    <td>SN</td>
                    <td><input type="text" name="SN" /></td>
                    <td><input type="number" name="SN_q" /></td>
                    <td><input type="text" name="SN_n" /></td>
                </tr>
                <tr>
                    <td>백신</td>
                    <td><input type="text" name="Antivirus" /></td>
                    <td><input type="number" name="Antivirus_q" /></td>
                    <td><input type="text" name="Antivirus_n" /></td>
                </tr>
                <tr>
                    <td>Main Program</td>
                    <td><input type="text" name="MainProgram" /></td>
                    <td><input type="number" name="MainProgram_q" /></td>
                    <td><input type="text" name="MainProgram_n" /></td>
                </tr>
                <tr>
                    <td>SSD</td>
                    <td><input type="text" name="SSD" /></td>
                    <td><input type="number" name="SSD_q" /></td>
                    <td><input type="text" name="SSD_n" /></td>
                </tr>
                <tr>
                    <td>DVD-ROM</td>
                    <td><input type="text" name="DVDROM" /></td>
                    <td><input type="number" name="DVDROM_q" /></td>
                    <td><input type="text" name="DVDROM_n" /></td>
                </tr>
                <tr>
                    <td>HDD</td>
                    <td><input type="text" name="HDD" /></td>
                    <td><input type="number" name="HDD_q" /></td>
                    <td><input type="text" name="HDD_n" /></td>
                </tr>
                <tr>
                    <td>NIC</td>
                    <td><input type="text" name="NIC" /></td>
                    <td><input type="number" name="NIC_q" /></td>
                    <td><input type="text" name="NIC_n" /></td>
                </tr>
                <tr>
                    <td>Controller</td>
                    <td><input type="text" name="Controller" /></td>
                    <td><input type="number" name="Controller_q" /></td>
                    <td><input type="text" name="Controller_n" /></td>
                </tr>
                <tr>
                    <td>HBA</td>
                    <td><input type="text" name="HBA" /></td>
                    <td><input type="number" name="HBA_q" /></td>
                    <td><input type="text" name="HBA_n" /></td>
                </tr>
                <tr>
                    <td>Drive</td>
                    <td><input type="text" name="Drive" /></td>
                    <td><input type="number" name="Drive_q" /></td>
                    <td><input type="text" name="Drive_n" /></td>
                </tr>
                <tr>
                    <td>Cartridge</td>
                    <td><input type="text" name="Cartridge" /></td>
                    <td><input type="number" name="Cartridge_q" /></td>
                    <td><input type="text" name="Cartridge_n" /></td>
                </tr>
                <tr>
                    <td>Streaming Solution</td>
                    <td><input type="text" name="StreamingSolution" /></td>
                    <td><input type="number" name="StreamingSolution_q" /></td>
                    <td><input type="text" name="StreamingSolution_n" /></td>
                </tr>
                <tr>
                    <td>Graphic Card</td>
                    <td><input type="text" name="GraphicCard" /></td>
                    <td><input type="number" name="GraphicCard_q" /></td>
                    <td><input type="text" name="GraphicCard_n" /></td>
                </tr>
                <tr>
                    <td>Cluster</td>
                    <td><input type="text" name="Cluster" /></td>
                    <td><input type="number" name="Cluster_q" /></td>
                    <td><input type="text" name="Cluster_n" /></td>
                </tr>
                <tr>
                    <td>Backup Repository</td>
                    <td><input type="text" name="BackupRepository" /></td>
                    <td><input type="number" name="BackupRepository_q" /></td>
                    <td><input type="text" name="BackupRepository_n" /></td>
                </tr>
                <tr>
                    <td>Etc</td>
                    <td><input type="text" name="etc" /></td>
                    <td><input type="number" name="etc_q" /></td>
                    <td><input type="text" name="etc_n" /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>