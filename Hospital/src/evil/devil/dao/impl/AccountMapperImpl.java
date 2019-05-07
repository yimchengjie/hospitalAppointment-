package evil.devil.dao.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import evil.devil.dao.AccountMapper;
import evil.devil.entity.Account;

public class AccountMapperImpl implements AccountMapper{
	static SqlSession session;
	static {
		String resource = "conf.xml";
		InputStream is = DepartmentMapperImpl.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		session = sessionFactory.openSession(true);
		}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int i= session.delete("evil.devil.dao.AccountMapper.deleteByPrimaryKey",id);
		return i;
	}
	@Override
	public int insert(Account record) {
		// TODO Auto-generated method stub
		int i= session.insert("evil.devil.dao.AccountMapper.insert",record);
		return i;
	}

	@Override
	public int insertSelective(Account record) {
		// TODO Auto-generated method stub
		int i= session.insert("evil.devil.dao.AccountMapper.insertSelective",record);
		return i;
	}

	@Override
	public Account selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		Account account= session.selectOne("evil.devil.dao.AccountMapper.selectByPrimaryKey",id);
		return account;
	}

	@Override
	public int updateByPrimaryKeySelective(Account record) {
		int i= session.update("evil.devil.dao.AccountMapper.updateByPrimaryKeySelective",record);
		return i;
	}

	@Override
	public int updateByPrimaryKey(Account record) {
		int i= session.update("evil.devil.dao.AccountMapper.updateByPrimaryKey",record);
		return i;
	}
	
	@Override
	public List<Account> selectAll() {
		// TODO Auto-generated method stub
		List<Account> list =session.selectList("evil.devil.dao.AccountMapper.selectAll");
		return list;
	}
	@Override
	public Account selectByUser(Integer id) {
		// TODO Auto-generated method stub
		Account account =session.selectOne("evil.devil.dao.AccountMapper.selectByUser",id);
		return account;
	}
	@Override
	public Account selectByDoctor(Integer id) {
		// TODO Auto-generated method stub
		Account account =session.selectOne("evil.devil.dao.AccountMapper.selectByDoctor",id);
		return account;
	}
	public static void main(String[] args) {
		AccountMapperImpl accountMapperImpl=new AccountMapperImpl();
//		Account account=accountMapperImpl.selectByPrimaryKey(1);
//		account.setDoctorId(2);
//		System.out.println(account.toString());
//		System.out.println(accountMapperImpl.updateByPrimaryKey(account));
		System.out.println(accountMapperImpl.selectByUser(1).getDoctorId());
	}

}
