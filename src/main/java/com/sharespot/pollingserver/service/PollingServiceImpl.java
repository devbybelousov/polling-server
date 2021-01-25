package com.sharespot.pollingserver.service;

import com.sharespot.pollingserver.model.Question;
import com.sharespot.pollingserver.model.Survey;
import com.sharespot.pollingserver.payload.QuestionRequest;
import com.sharespot.pollingserver.payload.SurveyRequest;
import com.sharespot.pollingserver.repository.QuestionRepository;
import com.sharespot.pollingserver.repository.SurveyRepository;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
  public int deleteSurvey(Long id) {
    if (!surveyRepository.existsById(id)) {
      return 0;
    }
    surveyRepository.deleteById(id);
    return 1;
  }

  @Override
  public int updateSurvey(Survey survey) {
    if (!surveyRepository.existsById(survey.getId())) {
      return 0;
    }
    surveyRepository.save(survey);
    return 1;
  }

  @Override
  public int createSurvey(SurveyRequest surveyRequest) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Survey survey = new Survey();
    survey.setTitle(surveyRequest.getTitle());
    try {
      survey.setStartDate(new Timestamp(dateFormat.parse(surveyRequest.getStartDate()).getTime()));
      survey.setEndDate(new Timestamp(dateFormat.parse(surveyRequest.getEndDate()).getTime()));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    survey.setIsActive(surveyRequest.getIsActive());
    ArrayList<Question> questions = new ArrayList<>();
    for (QuestionRequest question :
        surveyRequest.getQuestions()) {
      questions.add(new Question(question.getTitle(), question.getDisplayOrder()));
    }
    survey.setQuestions(questions);
    surveyRepository.save(survey);
    return 1;
  }

  @Override
  public List<Survey> getAllSurvey(int sort) {
    if (sort == 1) {
      return surveyRepository.findAllByOrderByStartDate();
    }
    return surveyRepository.findAllByOrderByTitle();
  }

  @Override
  public List<Survey> getAllSurveyByTitle(String title, int sort) {
    if (sort == 1) {
      return surveyRepository.findAllByTitleOrderByStartDate(title);
    }
    return surveyRepository.findAllByTitleOrderByTitle(title);
  }

  @Override
  public List<Survey> getAllSurveyByDate(String date, int sort) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dateTime = new Date();
    try {
      dateTime = dateFormat.parse(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    if (sort == 1) {
      return surveyRepository.findAllByEndDateGreaterThanAndStartDateLessThanOrderByStartDate(
          new Timestamp(dateTime.getTime()), new Timestamp(dateTime.getTime()));
    }
    return surveyRepository.findAllByEndDateGreaterThanAndStartDateLessThanOrderByTitle(
        new Timestamp(dateTime.getTime()), new Timestamp(dateTime.getTime()));
  }

  @Override
  public List<Survey> getAllSurveyByActive(Boolean active, int sort) {
    if (sort == 1) {
      return surveyRepository.findAllByIsActiveOrderByStartDate(active);
    }
    return surveyRepository.findAllByIsActiveOrderByTitle(active);
  }
}
