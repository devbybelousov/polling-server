package com.sharespot.pollingserver.service;

import com.sharespot.pollingserver.model.Survey;
import com.sharespot.pollingserver.payload.ApiResponse;
import com.sharespot.pollingserver.payload.SurveyRequest;
import com.sharespot.pollingserver.repository.QuestionRepository;
import com.sharespot.pollingserver.repository.SurveyRepository;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollingServiceImpl implements PollingService {

  @Autowired
  SurveyRepository surveyRepository;

  @Autowired
  QuestionRepository questionRepository;

  @Override
  public ApiResponse deleteSurvey(Long id) {
    if (!surveyRepository.existsById(id)) {
      return new ApiResponse(false, "The survey is not found!");
    }
    surveyRepository.deleteById(id);
    return new ApiResponse(true, "The survey was deleted successfully!");
  }

  @Override
  public ApiResponse updateSurvey(Survey survey) {
    survey.setQuestions(questionRepository.saveAll(survey.getQuestions()));
    surveyRepository.save(survey);
    return new ApiResponse(true, "The survey was updated successfully!");
  }

  @Override
  public ApiResponse createSurvey(SurveyRequest surveyRequest) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Survey survey = new Survey();
    survey.setTitle(surveyRequest.getTitle());
    try {
      survey.setStartDate(new Timestamp(dateFormat.parse(surveyRequest.getStartDate()).getTime()));
      survey.setEndDate(new Timestamp(dateFormat.parse(surveyRequest.getEndDate()).getTime()));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    survey.setIsActive(surveyRequest.getActive());
    survey.setQuestions(questionRepository.saveAll(surveyRequest.getQuestions()));
    surveyRepository.save(survey);
    return new ApiResponse(true, "The survey was created successfully!");
  }

  @Override
  public List<Survey> getAllSurvey(String sort) {
    if (sort.equals("date")) {
      return surveyRepository.findAllByOrderByStartDate();
    }
    return surveyRepository.findAllByOrderByTitle();
  }

  @Override
  public List<Survey> getAllSurveyByTitle(String title, String sort) {
    if (sort.equals("date")) {
      return surveyRepository.findAllByTitleOrderByStartDate(title);
    }
    return surveyRepository.findAllByTitleOrderByTitle(title);
  }

  @Override
  public List<Survey> getAllSurveyByDate(String date, String sort) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dateTime = new Date();
    try {
      dateTime = dateFormat.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    if (sort.equals("date")) {
      return surveyRepository.findAllByEndDateGreaterThanAndStartDateLessThanOrderByStartDate(
          new Timestamp(dateTime.getTime()), new Timestamp(dateTime.getTime()));
    }
    return surveyRepository.findAllByEndDateGreaterThanAndStartDateLessThanOrderByTitle(
        new Timestamp(dateTime.getTime()), new Timestamp(dateTime.getTime()));
  }

  @Override
  public List<Survey> getAllSurveyByActive(Boolean active, String sort) {
    if (sort.equals("date")) {
      return surveyRepository.findAllByIsActiveOrderByStartDate(active);
    }
    return surveyRepository.findAllByIsActiveOrderByTitle(active);
  }
}
