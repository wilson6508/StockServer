package com.service.api;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Service
public class GoogleSheetService {

    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.DRIVE);
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String APPLICATION_NAME = "SheetApi";

    public Sheets getSheets() {
        try {
            InputStream inputStream = GoogleSheetService.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
            GoogleCredential credential = GoogleCredential.fromStream(inputStream).createScoped(SCOPES);
            NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            return new Sheets.Builder(httpTransport, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<List<Object>> readData(String sheetId, String range) {
        try {
            Sheets sheets = getSheets();
            ValueRange response = sheets.spreadsheets().values().get(sheetId, range).execute();
            return response.getValues();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertData(String sheetId, String range, List<Object> newData) {
        try {
            Sheets sheets = getSheets();
            ValueRange appendBody = new ValueRange().setValues(Collections.singletonList(newData));
            sheets.spreadsheets()
                    .values()
                    .append(sheetId, range, appendBody)
                    .setValueInputOption("USER_ENTERED")
                    .setInsertDataOption("INSERT_ROWS")
                    .setIncludeValuesInResponse(true)
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateData(String sheetId, String range, List<Object> newData) {
        try {
            Sheets sheets = getSheets();
            ValueRange updateBody = new ValueRange().setValues(Collections.singletonList(newData));
            sheets.spreadsheets()
                    .values()
                    .update(sheetId, range, updateBody)
                    .setValueInputOption("RAW")
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

