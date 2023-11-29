package com.wiprojobsearch.joblisting.repository;

import com.wiprojobsearch.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface PostRepository extends MongoRepository<Post,String>
{
    @Query("{'createDate' : {$gte:?0}}")
    List<Post> findPostsCreatedWithinLast30Days(Date thirtyDaysAgo);

    @Query("{'createDate' : {$lte : ?0}}")
    List<Post> findPostsCreatedWithinLast30DaysAndOlder(Date thirtyDaysAgo);


    List<Post> findByTechsIn(Set<String> skills);
    Post findTopByOrderByTotalViewsCountDesc();
    List<Post> findByCompanyInAndTechsIn(List<String> companies, Set<String> skills);

    List<Post> findByLocationIn(Set<String> locations);


}
