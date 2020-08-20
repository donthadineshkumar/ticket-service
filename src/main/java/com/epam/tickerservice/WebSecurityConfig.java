package com.epam.tickerservice;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {//extends WebSecurityConfigurerAdapter {

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("foo")
                .password(passwordEncoder().encode("bar1"))
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                .antMatchers("/tickets/**").hasRole("USER")
                .antMatchers("/simple/**").hasRole("USER");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

}
