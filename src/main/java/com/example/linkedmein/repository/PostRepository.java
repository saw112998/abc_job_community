package com.example.linkedmein.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.linkedmein.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	
	@Query("SELECT p FROM Post p where p.company = :company")
	public Post findPostByCompany(String company);
	
	@Query("SELECT p FROM Post p where p.id = :id")
	public Post findPostById(Integer id);
	
	@Query("SELECT p FROM Post p where p.position = :position")
	public Post findPostByPosition(String position);
	
	@Query("SELECT p FROM Post p where p.city = :city")
	public Post findPostByCity(String city);

	@Query(value = "SELECT p FROM Post p WHERE p.company LIKE '%' || :keyword || '%'"
			+ " OR p.position LIKE '%' || :keyword || '%'"
			+ " OR p.city LIKE '%' || :keyword || '%'"
			+ " OR p.country LIKE '%' || :keyword || '%'"
			+ " OR p.salary LIKE '%' || :keyword || '%'"
			+ " OR p.content LIKE '%' || :keyword || '%'"
			)
	public List<Post> search(@Param("keyword") String keyword);
}
