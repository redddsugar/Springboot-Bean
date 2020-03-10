package com.ln.daoOne;

import com.ln.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface BookDaoOne extends JpaRepository<Book,Integer> {


}
