package cn.ishutter.demo;

import cn.ishutter.demo.entity.Department;
import cn.ishutter.demo.entity.Role;
import cn.ishutter.demo.entity.User;
import cn.ishutter.demo.repository.DepartmentRepository;
import cn.ishutter.demo.repository.RoleRepository;
import cn.ishutter.demo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class DemoApplicationTests {
	private Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	RoleRepository roleRepository;

	@Before
	public void initData(){
		userRepository.deleteAll();
		roleRepository.deleteAll();
		departmentRepository.deleteAll();

		Department department =  new Department();
		department.setName("技术部");
		departmentRepository.save(department);
		Assert.assertNotNull(department.getId());


		Role role = new Role();
		role.setName("Admin");
		roleRepository.save(role);
		Assert.assertNotNull(role.getId());

		User user = new User();
		user.setName("bruce");
		user.setDepartment(department);
		user.setCreatedate(new Date());
		List<Role> roles = roleRepository.findAll();
		user.setRoles(roles);
		userRepository.save(user);

		Assert.assertNotNull(user.getId());




	}

	@Test
	public void findPage(){

		PageRequest pageRequest = PageRequest.of(0,10,new Sort(Sort.Direction.ASC,"id"));
		Page<User> page = userRepository.findAll(pageRequest);
		Assert.assertNotNull(page);
		for(User user: page.getContent()){
			logger.info(user.getName());
		}

	}

}

