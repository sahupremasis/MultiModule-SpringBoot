package com.postgres.repository;

import com.postgres.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    @Query(value = "SELECT * FROM Person", nativeQuery = true)
    List<PersonEntity> findAllPersons();

    @Query(value = "SELECT * FROM Person p WHERE p.name = :name", nativeQuery = true)
    List<PersonEntity> findPersonsByName(@Param("name") String name);

    @Query(value = "SELECT * FROM Person p WHERE p.created_on < :createdOn", nativeQuery = true)
    List<PersonEntity> findPersonsCreatedOnOlderThan(@Param("createdOn") Instant createdOn);

    @Modifying
    @Query(value = "DELETE FROM Person p WHERE p.created_on < :createdOn", nativeQuery = true)
    void deletePersonsCreatedOnOlderThan(@Param("createdOn") Instant createdOn);

}
