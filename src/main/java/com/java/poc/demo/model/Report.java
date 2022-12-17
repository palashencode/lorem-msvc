package com.java.poc.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.java.poc.demo.utils.LoremIpsumGenerator;

import java.util.*;

@JsonRootName("Reports")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Report {

    @JsonProperty("id")
    private String reportId;

    @JsonProperty("title")
    private String reportTitle;

    @JsonProperty("type")
    private String reportType;

    @JsonProperty("owner")
    private String reportOwner;

    @JsonProperty("ownerType")
    private String reportOwnerType;

    @JsonProperty("text")
    private String reportText;

    @JsonProperty("len")
    private String reportLength;

    @JsonProperty("publishDate")
    private Date reportPublishDate;

    private static String uuidString(){
        return UUID.randomUUID().toString();
    }

    public static String[] reportOwners = new String[]{
            "ANALYST",
            "COMPANY",
            "COLLECTIONS",
            "PERIODICALS",
    };

    public static Map<String, List<Report>> generateReportInBulk(){
        Map<String, List<Report>> reports = new HashMap<>();

        Random random = new Random();
        int minReportC = 5;
        int maxReportC = 12;

        List<Report> analystReports = getReportBasedOnOwnerType(random, analystNames,
                                        "ANALYST",minReportC, maxReportC);

        List<Report> companyReports = getReportBasedOnOwnerType(random, companyNames,
                "COMPANY",minReportC, maxReportC);

        List<Report> collectionReports = getReportBasedOnOwnerType(random, collectionNames,
                "COLLECTIONS",minReportC, maxReportC);

        List<Report> pepriodicalReports = getReportBasedOnOwnerType(random, periodicalNames,
                "PERIODICALS",minReportC, maxReportC);


        reports.put("ANALYST", analystReports);
        reports.put("COMPANY", companyReports);
        reports.put("COLLECTIONS", collectionReports);
        reports.put("PERIODICALS", pepriodicalReports);

        return reports;
    }

    private static List<Report> getReportBasedOnOwnerType(Random random,
                                                          String[] reportOwnerNames,
                                                          String reportOwnerType,
                                                          int minReportC, int maxReportC){
        List<Report> reportList = new ArrayList<>();
        for(String reportOwner: reportOwnerNames){
            reportList.addAll(genReportList(random, reportOwner, reportOwnerType,
                    (random.nextInt(maxReportC- minReportC)+minReportC)));
        }
        return reportList;
    }

    private static List<Report> genReportList(Random random, String reportOwner,
                                              String reportOwnerType, int reportCount){
        List<Report> reportList = new ArrayList<>();

        for (int i = 0; i < reportCount; i++) {
            reportList.add(genReport(random, reportOwner, reportOwnerType));
        }

        return reportList;
    }

    private static Report genReport(Random random, String reportOwner, String reportOwnerType){
        Report report = new Report(uuidString());
        report.setReportTitle(generateReportTitle(random,reportOwner, reportOwnerType));
        report.setReportOwner(reportOwner);
        report.setReportOwnerType(reportOwnerType);
        report.setReportPublishDate(new Date());
        report.setReportLength((random.nextInt(200)+20) + " Pages");
        report.setReportText(LoremIpsumGenerator.getText(20));
        return report;
    }

    private static String generateReportTitle(Random random, String reportOwner, String reportOwnerType){
        String reportTitle = "";
        if("COMPANY".equals(reportOwnerType)){
            reportTitle = reportOwner+", " + getRandomElement(random, titleArr);
        }else{
            reportTitle = getRandomElement(random, titleArr);
        }
        return reportTitle;
    }

    public Report(String reportId) {
        this.reportId = reportId;
      }

    public Report(String reportId, String reportTitle, String reportType,
                  String reportOwner, String reportOwnerType, String reportText,
                  String reportLength, Date reportPublishDate) {
        this.reportId = reportId;
        this.reportTitle = reportTitle;
        this.reportType = reportType;
        this.reportOwner = reportOwner;
        this.reportOwnerType = reportOwnerType;
        this.reportText = reportText;
        this.reportLength = reportLength;
        this.reportPublishDate = reportPublishDate;
    }



    private static String getRandomElement(Random random, String[] arr){
        return arr[random.nextInt(arr.length)];
    }


    public static String[] periodicalNames = new String[]{
            "Periodical Crypto Currency Trends",
            "Periodical Forex  Currency Trends",
            "Periodical Securities Trends",
            "Periodical Fixed Income Assets Trends",
            "Periodical Real Estate Trends",
    };


    public static String[] collectionNames = new String[]{
            "Global Crypto Currency Trends",
            "Global Forex  Currency Trends",
            "Global Securities Trends",
            "Global Fixed Income Assets Trends",
            "Global Real Estate Trends",
    };

    public static String[] companyNames = new String[]{
            "Morgan Stanley",
            "Google",
            "Apple",
            "Meta",
            "Zomato",
            "Swiggy",
            "Paytm",
            "Paypal",
            "Huawei"
    };

    public static String[] analystNames = new String[]{
            "Faucette, James",
            "Huberty, Katy",
            "Kumari, Shalini",
            "Morgan,Brain",
            "Zerbe, Ken"
    };

    public static String[] reportTypes = new String[]{
        "BLUEPAPER",
        "IDEA",
        "INSIGHT",
        "UPDATE"
    };

    private static String[] titleArr = new String[]{
        "Household & Health Care",
        "Global Macro Strategy : Cobalt Foundation",
        "Research Macro Trend ",
        "Research Currency Trend ",
        "Research Commodities Trend ",
        "Research Fixed Income Trend",
        "Research Securities Trend ",
        "Research Swift Impact",
        "Research Petro Price Trend "
    };

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportOwner() {
        return reportOwner;
    }

    public void setReportOwner(String reportOwner) {
        this.reportOwner = reportOwner;
    }

    public String getReportOwnerType() {
        return reportOwnerType;
    }

    public void setReportOwnerType(String reportOwnerType) {
        this.reportOwnerType = reportOwnerType;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public String getReportLength() {
        return reportLength;
    }

    public void setReportLength(String reportLength) {
        this.reportLength = reportLength;
    }

    public Date getReportPublishDate() {
        return reportPublishDate;
    }

    public void setReportPublishDate(Date reportPublishDate) {
        this.reportPublishDate = reportPublishDate;
    }
}
