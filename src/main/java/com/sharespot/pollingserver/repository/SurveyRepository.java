package com.sharespot.pollingserver.repository;

import com.sharespot.pollingserver.model.Survey;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
  List<Survey> findAllByOrderByTitle();
  List<Survey> findAllByTitleOrderByTitle(String title);
  List<Survey> findAllByIsActiveOrderByTitle(Boolean active);
  List<Survey> findAllByEndDateGreaterThanAndStartDateLessThanOrderByTitle(Timestamp endDate, Timestamp startDate);
  List<Survey> findAllByOrderByStartDate();
  List<Survey> findAllByTitleOrderByStartDate(String title);
  List<Survey> findAllByIsActiveOrderByStartDate(Boolean active);
  List<Survey> findAllByEndDateGreaterThanAndStartDateLessThanOrderByStartDate(Timestamp endDate, Timestamp startDate);
}
