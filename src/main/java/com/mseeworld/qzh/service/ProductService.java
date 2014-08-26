package com.mseeworld.qzh.service;

import java.util.List;

import com.mseeworld.qzh.model.Product;
import com.mseeworld.qzh.model.AUser;
import com.mseeworld.qzh.util.QshException;

/**
 * 商品服务类
 * @author 邱盛华
 */
public interface ProductService {
	/**新增商品*/
	public Product add(Product product);
	/**删除商品*/
	public boolean remove(String[] ids);
	/**修改商品*/
	public boolean modify(Product product);
	/**查询所有商品*/
	public List<Product> findAll(int start, int limit);
	/**分页查询所有商品*/
	public List<Product> findAll();
	/**查询关键字*/
	public List<Product> findByKeyword(String keyword);
	/**返回用的的记录数*/
	public long count();
	
}
