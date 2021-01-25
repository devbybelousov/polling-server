package com.sharespot.pollingserver.controller;

import com.sharespot.pollingserver.payload.SurveyRequest;
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

  @GetMapping("/survey")
  public ResponseEntity<?> getAllSurvey(@RequestParam String title){
    return ResponseEntity.ok("");
  }

  @PostMapping("/survey")
  public ResponseEntity<?> createSurvey(@RequestBody SurveyRequest survey){
    return ResponseEntity.ok("");
  }

  @DeleteMapping("/survey")
  public ResponseEntity<?> deleteSurvey(@RequestParam Long id){
    return ResponseEntity.ok("");
  }

  @PutMapping("/survey")
  public ResponseEntity<?> updateSurvey(@RequestBody SurveyRequest survey){
    return ResponseEntity.ok("");
  }

}
