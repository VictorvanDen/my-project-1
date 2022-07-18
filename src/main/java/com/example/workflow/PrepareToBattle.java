package com.example.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class PrepareToBattle implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int warri = (int)delegateExecution.getVariable("Warrious");
        if (warri == 1) {
        	throw new BpmnError("warri");
        }
    	int eW = 100;
    	boolean isWin = false;
        String bStatus = "Un";
        if(warri > eW) {
        	isWin = true;
        	bStatus = "Vic";
        } else {
        	bStatus = "Fail";
        	isWin = false;
        }
        
        delegateExecution.setVariable("enemyWarrious", eW);
        delegateExecution.setVariable("battleStatus", bStatus);
        delegateExecution.setVariable("isWin", isWin);
    }
}
