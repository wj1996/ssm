package com.wj.springmvc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * S:Ô´
 * T:Ä¿±ê
 * @author 24253
 *
 */
public class DataConvert implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		Date parse = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			parse = sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse;
	}
	

}
