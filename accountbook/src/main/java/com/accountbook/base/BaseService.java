package com.accountbook.base;

import java.util.List;

public interface BaseService<T> {
	
	public T selectOne(Integer seq);
	
	public List<T> selectList(Integer seq);
	
	public T insertOne(T entity);
	
	public List<T> insertList(List<T> entityList);
	
	public T updateOne(T entity);
	
	public List<T> updateList(List<T> entityList);
	
	public void deleteOne(T entity);
	
	public void deleteList(List<T> entityList);
	
}
