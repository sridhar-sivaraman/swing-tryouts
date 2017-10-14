package com.iopex.utils;

import java.io.File;

import com.iopex.Constants;

public class ResourceUtils {

	public static String getFile(String imageIcon) {
		if ((new File(imageIcon).exists())) {
			return imageIcon;
		}
		return Constants.RESOURCE_PREFIX + imageIcon;
	}

}
