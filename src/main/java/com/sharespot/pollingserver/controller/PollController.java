package com.sharespot.pollingserver.controller;

import com.sharespot.pollingserver.model.Survey;
import com.sharespot.pollingserver.payload.SurveyRequest;
import com.sharespot.pollingserver.service.PollingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PollController {

  @Autowired
  PollingService pollingService;

  @GetMapping("/survey")
  public ResponseEntity<?> getAllSurvey(@RequestParam String sort) {
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
        .body(pollingService.getAllSurvey(sort));
  }

  @GetMapping("/survey/title")
  public ResponseEntity<?> getAllSurveyByTitle(@RequestParam String sort,
      @RequestParam(name = "sort") String title) {
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
        .body(pollingService.getAllSurveyByTitle(title, sort));
  }

  @GetMapping("/survey/date")
  public ResponseEntity<?> getAllSurveyByDate(@RequestParam String sort,
      @RequestParam(name = "date") String date) {
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
        .body(pollingService.getAllSurveyByDate(date, sort));
  }

  @GetMapping("/survey/active")
  public ResponseEntity<?> getAllSurveyByActive(@RequestParam String sort,
      @RequestParam(name = "active") Boolean active) {
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
        .body(pollingService.getAllSurveyByActive(active, sort));
  }

  @PostMapping("/survey")
  public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest survey) {
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
        .body(pollingService.createSurvey(survey));
  }

  @DeleteMapping("/survey")
  public ResponseEntity<?> deleteSurvey(@RequestParam Long id) {
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
        .body(pollingService.deleteSurvey(id));
  }

  @PutMapping("/survey")
  public ResponseEntity<?> updateSurvey(@RequestBody Survey survey) {
    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(pollingService.updateSurvey(survey));
  }

}
