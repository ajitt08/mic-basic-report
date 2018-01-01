package com.wolfattire.service;

import com.wolfattire.responseDto.ReportResponseDto;

public interface HomeService {

	public ReportResponseDto getReportsFromShopify(String fromDate, String toDate);
}
