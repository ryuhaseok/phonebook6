package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 삭제
	public int personDelete(int no) {
		System.out.println("PhonebookDao.personDelete()");
		
		int count = sqlSession.delete("phonebook.delete", no);

		return count;
	}
	
	// 수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("PhonebookDao.personUpdate()");
		
		int count = sqlSession.update("phonebook.update", personVo);
		
		return count;
	}
	
	// 수정폼 정보 가져오기
	public PersonVo personSelectModifyForm(int no) {
		System.out.println("PhonebookDao.personSelectModifyForm()");

		PersonVo personVo = sqlSession.selectOne("phonebook.personSelectModifyForm", no);
		System.out.println(personVo);
		
		return personVo;
	}
	
	//등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");
		
		int count = sqlSession.insert("phonebook.insert", personVo);
		return count;
	}
	
	//전체 리스트 가져오기
	public List<PersonVo> personSelectAll() {
		System.out.println("PhonebookDao.personSelectAll()");
		
		List<PersonVo> pList = sqlSession.selectList("phonebook.selectList");
		
		return pList;
	}

}
