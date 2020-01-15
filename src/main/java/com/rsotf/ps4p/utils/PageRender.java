package com.rsotf.ps4p.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRender<T> {

	private String url;
	private Page<T> page;
	private int elementosXPage;
	private int pageActual;
	private int totalPaginas;
	
	private List<PageItem> paginas;
	public PageRender(String url, Page<T> page) {
		
		this.paginas = new ArrayList<PageItem>();
		this.url = url;
		this.page = page;
		
		elementosXPage = page.getSize();
		totalPaginas = page.getTotalPages();
		pageActual = page.getNumber() + 1;
		
		int desde, hasta;
		
		if (totalPaginas <= elementosXPage) {
			desde = 1;
			hasta = totalPaginas;
		}else if(pageActual <= elementosXPage/2) {
			desde = 1;
			hasta = elementosXPage;
		}else if (pageActual >= totalPaginas - elementosXPage/2) {
			desde = totalPaginas - elementosXPage + 1;
			hasta = elementosXPage;
		}else {
			desde = pageActual - elementosXPage/2;
			hasta = elementosXPage;
		}
		
		for (int i = 0; i < hasta; i++) {
			paginas.add(new PageItem(desde + i, pageActual == desde + i));
		}		
		
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}
	
	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
}
