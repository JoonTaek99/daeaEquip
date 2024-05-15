package com.daea.daos;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.SqlMapConfig;
import com.daea.dtos.EquiDto;

public class EquiDao extends SqlMapConfig {
	
	private String namespace = "com.daea.";
	
	public boolean insertData(EquiDto dto) {
		int count = 0;
		SqlSession sqlSession = null;
		
		try {
			sqlSession = getSqlSessionFactory().openSession(true);
			count = sqlSession.insert(namespace + "insertData", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return count>0?true:false;
	}
	
	public List<EquiDto> getAllData() {
        List<EquiDto> list =  new ArrayList<>();
        SqlSession sqlSession = null;

        try {
            sqlSession = getSqlSessionFactory().openSession();
            list = sqlSession.selectList(namespace + "getAllData");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }
        System.out.println(list);
        return list;
    }
	
	public List<EquiDto> searchData(String keyword) {
        List<EquiDto> list =  new ArrayList<>();
        SqlSession sqlSession = null;

        try {
            sqlSession = getSqlSessionFactory().openSession();
            list = sqlSession.selectList(namespace + "searchData", keyword);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }
        System.out.println(list);
        return list;
    }

}