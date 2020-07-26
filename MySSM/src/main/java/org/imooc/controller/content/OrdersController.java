package org.imooc.controller.content;



import org.imooc.dto.OrdersDto;
import org.imooc.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@RequestMapping
	public String init(Model model, HttpServletRequest request) {
		OrdersDto ordersDto = new OrdersDto();
		System.out.println(ordersService.selectByPage(ordersDto));
		model.addAttribute("list", ordersService.selectByPage(ordersDto));
		model.addAttribute("searchParam", ordersDto);
		return "/content/orderList";
	}

	/**
	 * 查询
	 */
	@RequestMapping("/search")
	public String search(Model model, OrdersDto ordersDto) {
		model.addAttribute("list", ordersService.selectByPage(ordersDto));
		model.addAttribute("searchParam", ordersDto);
		return "/content/orderList";
	}

}