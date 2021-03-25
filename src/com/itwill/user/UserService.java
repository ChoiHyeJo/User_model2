package com.itwill.user;

import java.util.ArrayList;

public interface UserService {

	/*
	 * 회원가입
	 */
	int create(User user) throws Exception;

	/*
	 * 회원로그인
	 */
	User login(String userId, String password) throws Exception;

	/*
	 * 회원전체리스트
	 */
	ArrayList<User> findUserList() throws Exception;

	/*
	 * 회원1명보기
	 */
	User findUser(String userId) throws Exception;

	/*
	 * 회원수정
	 */
	int update(User user) throws Exception;

	/*
	  * 회원탈퇴
	  */
	int remove(String userId) throws Exception;

}