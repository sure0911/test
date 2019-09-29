package com.sylm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sylm.entity.User;

@Mapper
public interface UserMapper {
	@Select("select * from t_user where id = #{id}")
	public User getUserById(Integer id);

	@Options(useGeneratedKeys = true, keyProperty = "id") // 加入自增主键
	@Insert("insert into t_user(username,password,employeeNum,departmentId) values(#{username},#{password},#{employeeNum},#{departmentId})")
	public int insertUser(User user);

	@Delete("delete from t_user where id=#{id}")
	public int deleteById(Integer id);

	@Update("update t_user set username=#{username},password=#{password} where id=#{id}")
	public int updateUser(User user);

	@Select("select * from t_user")
	public List<User> getALLUsers();
}