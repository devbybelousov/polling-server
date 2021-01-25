package com.sharespot.pollingserver.service;

import com.sharespot.pollingserver.model.Survey;
import com.sharespot.pollingserver.payload.ApiResponse;
import com.sharespot.pollingserver.payload.SurveyRequest;
import java.util.List;

public interface PollingService {

  int deleteSurvey(Long id);

  int updateSurvey(Survey survey);

  int createSurvey(SurveyRequest surveyRequest);

  List<Survey> getAllSurvey(int sort);

  List<Survey> getAllSurveyByTitle(String title, int sort);

  List<Survey> getAllSurveyByDate(String date, int sort);

  List<Survey> getAllSurveyByActive(Boolean active, int sort);
}
