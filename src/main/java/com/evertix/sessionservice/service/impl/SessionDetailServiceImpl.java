package com.evertix.sessionservice.service.impl;

import com.evertix.sessionservice.entities.SessionDetail;
import com.evertix.sessionservice.repository.SessionDetailRepository;
import com.evertix.sessionservice.service.SessionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SessionDetailServiceImpl implements SessionDetailService {
    @Autowired
    private SessionDetailRepository sessionDetailRepository;

    @Override
    public Page<SessionDetail> getAllSessionDetails(Pageable pageable) {
        return this.sessionDetailRepository.findAll(pageable);
    }


    @Override
    public Page<SessionDetail> getAllSessionDetailsBySessionId(Long sessionId, Pageable pageable) {
        return sessionDetailRepository.findAllBySessionId(sessionId, pageable);
    }
/*
    @Override
    public SessionDetail createSessionDetail(Long sessionId, Long teacherId, SessionDetail sessionDetail) {
        return sessionRepository.findById(sessionId).map(session -> {
            return userRepository.findById(teacherId).map(user -> {
                sessionDetail.setTeacher(user);
                sessionDetail.setSession(session);
                return sessionDetailRepository.save(sessionDetail);
            }).orElseThrow(()-> new ResourceNotFoundException("Teacher with Id: "+teacherId+" not found"));
        }).orElseThrow(()-> new ResourceNotFoundException("Session with Id: "+sessionId+" not found"));
    }

    @Override
    public SessionDetail updateSessionDetail(Long sessionId, Long teacherId, Long sessionDetailId, SessionDetail sessionDetailDetails) {
        return sessionRepository.findById(sessionId).map(session -> {
            return userRepository.findById(teacherId).map(user -> {
                return sessionDetailRepository.findById(sessionDetailId).map(sessionDetail -> {
                    sessionDetail.setTeacher(user);
                    sessionDetail.setSession(session);
                    sessionDetail.setState(sessionDetailDetails.getState());
                    return sessionDetailRepository.save(sessionDetail);
                }).orElseThrow(()-> new ResourceNotFoundException("SessionDetail with Id: "+sessionDetailId+" not found"));
            }).orElseThrow(()-> new ResourceNotFoundException("Teacher with Id: "+teacherId+" not found"));
        }).orElseThrow(()-> new ResourceNotFoundException("Session with Id: "+sessionId+" not found"));
    }

    @Override
    public ResponseEntity<?> deleteSessionDetail(Long sessionId, Long teacherId, Long sessionDetailId) {
        return sessionRepository.findById(sessionId).map(session -> {
            return userRepository.findById(teacherId).map(user -> {
                return sessionDetailRepository.findById(sessionDetailId).map(sessionDetail -> {
                    sessionDetailRepository.delete(sessionDetail);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()-> new ResourceNotFoundException("SessionDetail with Id: "+sessionDetailId+" not found"));
            }).orElseThrow(()-> new ResourceNotFoundException("Teacher with Id: "+teacherId+" not found"));
        }).orElseThrow(()-> new ResourceNotFoundException("Session with Id: "+sessionId+" not found"));
    }

     */
}
