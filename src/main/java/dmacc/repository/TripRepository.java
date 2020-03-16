package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

}
