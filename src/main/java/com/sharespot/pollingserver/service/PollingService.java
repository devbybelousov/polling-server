package com.sharespot.pollingserver.service;

import com.sharespot.pollingserver.model.Survey;
import com.sharespot.pollingserver.payload.ApiResponse;
import com.sharespot.pollingserver.payload.SurveyRequest;
import java.sql.Timestamp;
import java.util.List;

public interface PollingService {

  ApiResponse deleteSurvey(Long id);

  ApiResponse updateSurvey(Survey survey);

  ApiResponse createSurvey(SurveyRequest surveyRequest);

  List<Survey> getAllSurvey(String sort);

  List<Survey> getAllSurveyByTitle(String title, String sort);

  List<Survey> getAllSurveyByDate(String date, String sort);

  List<Survey> getAllSurveyByActive(Boolean active, String sort);
}
