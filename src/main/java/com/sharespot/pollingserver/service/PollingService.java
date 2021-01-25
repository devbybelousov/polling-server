package com.sharespot.pollingserver.service;

import com.sharespot.pollingserver.model.Survey;
import com.sharespot.pollingserver.payload.SurveyRequest;
import com.sharespot.pollingserver.repository.QuestionRepository;
import com.sharespot.pollingserver.repository.SurveyRepository;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollingService {

  @Autowired
  SurveyRepository surveyRepository;

  @Autowired
  QuestionRepository questionRepository;

  public void deleteSurvey(Long id) {
    surveyRepository.deleteById(id);
  }

  public void updateSurvey(SurveyRequest surveyRequest) {

  }

  public void createSurvey(SurveyRequest surveyRequest) {

  }

  public List<Survey> getAllSurvey(String sort) {
    if (sort.equals("date")) {
      return surveyRepository.findAllByOrderByStartDate();
    }
    return surveyRepository.findAllByOrderByTitle();
  }

  public List<Survey> getAllSurveyByTitle(String title, String sort) {
    if (sort.equals("date")) {
      return surveyRepository.findAllByTitleOrderByStartDate(title);
    }
    return surveyRepository.findAllByTitleOrderByTitle(title);
  }

  public List<Survey> getAllSurveyByDate(Timestamp date, String sort) {
    if (sort.equals("date")) {
      return surveyRepository.findAllByEndDateGreaterThanAndStartDateLessThanOrderByStartDate(date, date);
    }
    return surveyRepository.findAllByEndDateGreaterThanAndStartDateLessThanOrderByTitle(date, date);
  }

  public List<Survey> getAllSurveyByActive(Boolean active, String sort) {
    if (sort.equals("date")) {
      return surveyRepository.findAllByIsActiveOrderByStartDate(active);
    }
    return surveyRepository.findAllByIsActiveOrderByTitle(active);
  }
}
