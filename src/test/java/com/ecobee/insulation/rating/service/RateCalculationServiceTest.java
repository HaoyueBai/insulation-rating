package com.ecobee.insulation.rating.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Config.class)
class RateCalculationServiceTest {

    @InjectMocks
    private RateCalculationService rateCalculationService;

    @Mock
    private InputService inputService;

    @Test
    void reportRate_Normal() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        when(inputService.getNameToRvalue()).thenReturn(Util.getNameToRvalue_Normal());
        when(inputService.getProcessedData()).thenReturn(Util.getProcessedData_Normal());
        when(inputService.getQueries()).thenReturn(Util.getQueries_Normal());
        rateCalculationService.reportRate();
        assertEquals(Util.outPut_Normal,os.toString());
    }

    @Test
    void reportRate_invalidName() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        when(inputService.getNameToRvalue()).thenReturn(Util.getNameToRvalue_Normal());
        when(inputService.getProcessedData()).thenReturn(Util.getProcessedData_Normal());
        when(inputService.getQueries()).thenReturn(Util.getQueries_invalidName());
        rateCalculationService.reportRate();
        assertEquals(Util.outPut_invalidName,os.toString());
    }

    @Test
    void reportRate_sameRvalue(){
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        when(inputService.getNameToRvalue()).thenReturn(Util.getNameToRvalue_Normal());
        when(inputService.getProcessedData()).thenReturn(Util.getProcessedData_Normal());
        when(inputService.getQueries()).thenReturn(Util.getQueries_sameRvalue());
        rateCalculationService.reportRate();
        assertEquals(Util.outPut_sameRvalue,os.toString());
    }

    @Test
    void reportRate_invalidProvince(){
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        when(inputService.getNameToRvalue()).thenReturn(Util.getNameToRvalue_Normal());
        when(inputService.getProcessedData()).thenReturn(Util.getProcessedData_Normal());
        when(inputService.getQueries()).thenReturn(Util.getQueries_invalidProvince());
        rateCalculationService.reportRate();
        assertEquals(Util.outPut_invalidProvince,os.toString());
    }

    @Test
    void reportRate_invalidCountry(){
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        when(inputService.getNameToRvalue()).thenReturn(Util.getNameToRvalue_Normal());
        when(inputService.getProcessedData()).thenReturn(Util.getProcessedData_Normal());
        when(inputService.getQueries()).thenReturn(Util.getQueries_invalidCountry());
        rateCalculationService.reportRate();
        assertEquals(Util.outPut_invalidCountry,os.toString());
    }


    @Test
    void reportRate_invalidCity(){
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        when(inputService.getNameToRvalue()).thenReturn(Util.getNameToRvalue_Normal());
        when(inputService.getProcessedData()).thenReturn(Util.getProcessedData_Normal());
        when(inputService.getQueries()).thenReturn(Util.getQueries_invalidCity());
        rateCalculationService.reportRate();
        assertEquals(Util.outPut_invalidCity,os.toString());
    }

    @Test
    void reportRate_allSame(){
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        when(inputService.getNameToRvalue()).thenReturn(Util.getNameToRvalue_allSame());
        when(inputService.getProcessedData()).thenReturn(Util.getProcessedData_allSame());
        when(inputService.getQueries()).thenReturn(Util.getQueries_allSame());
        rateCalculationService.reportRate();
        assertEquals(Util.outPut_allSame,os.toString());
    }



}