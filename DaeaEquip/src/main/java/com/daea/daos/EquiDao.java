package com.daea.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.config.SqlMapConfig;
import com.daea.dtos.EquiDto;

public class EquiDao extends SqlMapConfig {
	
	private String namespace = "com.daea.";
	
	// 장비 입력
	public boolean insertData(EquiDto dto) {
	    int count = 0;
	    SqlSession sqlSession = null;

	    try {
	        sqlSession = getSqlSessionFactory().openSession(true);
	        count = sqlSession.insert(namespace + "insertData", dto);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (sqlSession != null) { // null 체크 추가
	            sqlSession.close();
	        }
	    }

	    return count > 0;
	}
	
	// 모든 장비 리스트 확인
//	public List<EquiDto> getAllData() {
//        List<EquiDto> list =  new ArrayList<>();
//        SqlSession sqlSession = null;
//
//        try {
//            sqlSession = getSqlSessionFactory().openSession();
//            list = sqlSession.selectList(namespace + "getAllData");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (sqlSession != null) sqlSession.close();
//        }
//        System.out.println(list);
//        return list;
//    }
	
	public List<EquiDto> getAllData(String pnum) {
	    List<EquiDto> list = new ArrayList<>();
	    SqlSession sqlSession = null;

	    Map<String, String> map = new HashMap<>();
	    map.put("pnum", pnum);

	    try {
	        sqlSession = getSqlSessionFactory().openSession(true);
	        list = sqlSession.selectList(namespace + "getAllData", map);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (sqlSession != null) { // null 체크 추가
	            sqlSession.close();
	        }
	    }
	    return list;
	}
	
	public int getPCount() {
	    int count = 0;
	    SqlSession sqlSession = null;

	    try {
	        sqlSession = getSqlSessionFactory().openSession(true);
	        count = sqlSession.selectOne(namespace + "getPCount");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (sqlSession != null) { // null 체크 추가
	            sqlSession.close();
	        }
	    }

	    return count;
	}

	
	// 장비 검색
	public List<EquiDto> searchData(String keyword) {
	    List<EquiDto> list = new ArrayList<>();
	    SqlSession sqlSession = null;

	    try {
	        sqlSession = getSqlSessionFactory().openSession();
	        list = sqlSession.selectList(namespace + "searchData", keyword);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (sqlSession != null) { // null 체크 추가
	            sqlSession.close();
	        }
	    }
	    return list;
	}

	// getDetailData 메서드 수정
	public EquiDto getDetailData(String assetNumber) {
	    EquiDto dto = new EquiDto();
	    SqlSession sqlSession = null;
	    try {
	        sqlSession = getSqlSessionFactory().openSession();
	        dto = sqlSession.selectOne(namespace + "detailData", assetNumber);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (sqlSession != null) { // null 체크 추가
	            sqlSession.close();
	        }
	    }

	    return dto;
	}

}