package bicycle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bicycle.repository.AdminRepository;
import bicycle.security.SignupForm;

// 사용자의 회원가입 처리
@Controller
@RequestMapping("/signup")
public class SignupController {
	private AdminRepository adminRepo;
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public SignupController(AdminRepository adminRepo, PasswordEncoder passwordEncoder) {
		this.adminRepo = adminRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping
	public String signup() {
		return "signup";
	}
	
	// 비밀번호를 인코딩하고 저장
	@PostMapping
	public String processSignup(SignupForm signupform) {
		adminRepo.save(signupform.toAdmin(passwordEncoder));
		return "redirect:/login";
	}
}