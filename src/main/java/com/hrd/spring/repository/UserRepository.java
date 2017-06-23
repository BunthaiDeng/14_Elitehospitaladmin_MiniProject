package com.hrd.spring.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hrd.spring.model.User;

@Repository
public interface UserRepository {
	
	@Select("select id, "
			+ "username, "
			+ "email, "
			+ "gender, "
			+ "phonenumber, "
			+ "status, "
			+ "user_hash, "
			+ "created_date "
			+ "from users")
	@Results(
				value={
					@Result(property="userhash", column="user_hash"),
					@Result(property="createddate", column="created_date")
				}
			)
	public ArrayList<User> findAllUser();
	
	@Insert("insert into users"
			+ "("
			+ "username, "
			+ "email, "
			+ "gender, "
			+ "phonenumber, "
			+ "user_hash"
			+ ") "
			+ "values("
			+ "#{user.username}, "
			+ "#{user.email}, "
			+ "#{user.gender}, "
			+ "#{user.phonenumber}, "
			+ "#{user.userhash}"
			+ ")")
	public boolean addUser(@Param("user") User user);
	
	@Update("update users set "
			+ "username = #{user.username}, "
			+ "email = #{user.email}, "
			+ "gender = #{user.gender}, "
			+ "phonenumber = #{user.phonenumber} "
			+ "where user_hash = #{user.userhash}")
	public boolean updateUser(@Param("user") User user);
	
	@Delete("delete from users where user_hash = #{userhash}")
	public boolean deleteUser(@Param("userhash") String userhash);
}
