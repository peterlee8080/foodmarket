package com.foodmarket.app.product.model;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository  // 可省略
public interface WorkProductRepository extends JpaRepository<WorkProduct, Long> {

	//用新增時間排序
	public WorkProduct findFirstByOrderByAddedDesc();
	
	//用Id查詢
		public WorkProduct findByproductid(Long productid);

	
	//用productcategory種類查詢
//		public WorkProduct findByProductcategory (String productcategory);
		//用商品名稱關鍵字查詢，有分頁
				@Query(value = "select * from product where productcategory like %:productcategory%", nativeQuery=true)
				public Page<WorkProduct> findByProductcategoryKey(Pageable pgb,@Param("productcategory")String productcategory);
		
		
		//用商品名稱關鍵字查詢，有分頁
		@Query(value = "select * from product where productname like %:productname%", nativeQuery=true)
		public Page<WorkProduct> findByName(Pageable pgb, @Param("productname")String productname);
	
		//用id刪除
		@Transactional
		@Modifying
		@Query(value = "delete from product where productid = :productid", nativeQuery=true)
		public void deleteproductidByIdSql(@Param("productid")Long productid);
		
		
		
}