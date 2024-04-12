import { useState, useEffect } from 'react';
import { Navbar, Nav, Container } from 'react-bootstrap';
import navIcon2 from '../assets/img/nav-icon2.svg';
import { BiChevronDown } from 'react-icons/bi';
import { BrowserRouter as Router } from 'react-router-dom';

export const NavBar = () => {
  const [activeLink, setActiveLink] = useState('home');
  const [scrolled, setScrolled] = useState(false);
  const [isSubMenuOpen, setIsSubMenuOpen] = useState(false);
  const [isSubMenuOpenForNotes, setIsSubMenuOpenForNotes] = useState(false);

  useEffect(() => {
    const onScroll = () => {
      if (window.scrollY > 50) {
        setScrolled(true);
      } else {
        setScrolled(false);
      }
    };

    window.addEventListener('scroll', onScroll);

    return () => window.removeEventListener('scroll', onScroll);
  }, []);

  const toggleMenu = () => {
    console.log('Toggle menu swagger clicked');
    setIsSubMenuOpen(!isSubMenuOpen);
  };
  const toggleNotesMenu = () => {
    console.log('Toggle menu notes clicked');
    setIsSubMenuOpenForNotes(!isSubMenuOpenForNotes);
  };

  const onUpdateActiveLink = value => {
    console.log('Update active link clicked');
    setActiveLink(value);
  };

  return (
    <Router>
      <Navbar expand="md" className={scrolled ? 'scrolled' : ''}>
        <Container>
          <Navbar.Brand href="/"></Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav">
            <span className="navbar-toggler-icon"></span>
          </Navbar.Toggle>
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="ms-auto">
              <Nav.Link
                href="/"
                className={activeLink === 'home' ? 'active navbar-link' : 'navbar-link'}
                onClick={() => onUpdateActiveLink('home')}
              >
                Home
              </Nav.Link>
              <Nav.Link
                className={activeLink === 'skills' ? 'active navbar-link' : 'navbar-link'}
                onClick={() => {
                  toggleMenu();
                  onUpdateActiveLink('skills');
                }}
              >
                Swagger <BiChevronDown />
              </Nav.Link>

              <Nav.Link
                className={activeLink === 'notes' ? 'active navbar-link' : 'navbar-link'}
                onClick={() => {
                  toggleNotesMenu();
                  onUpdateActiveLink('notes');
                }}
              >
                Notes <BiChevronDown />
              </Nav.Link>

              <Nav.Link
                href="/docs"
                className={activeLink === 'projects' ? 'active navbar-link' : 'navbar-link'}
                onClick={() => onUpdateActiveLink('projects')}
              >
                Docs
              </Nav.Link>
            </Nav>
            <div className={isSubMenuOpen ? 'sub-menu-wrap open-menu' : 'sub-menu-wrap'} id="subMenu">
              <div class="sub-menu">
                <a href="/swagger/action" class="sub-menu-link">
                  <img src=""></img>
                  <h5>action</h5>
                  <span>&gt;</span>
                </a>
                <hr></hr>
                <span></span>
                <a href="/swagger/notification" class="sub-menu-link">
                  <img src=""></img>
                  <h5>notification</h5>
                  <span>&gt;</span>
                </a>
              </div>
            </div>

            <div className={isSubMenuOpenForNotes ? 'sub-menu-wrap open-menu' : 'sub-menu-wrap'} id="subMenu">
              <div class="sub-menu">
                <a href="/notes/action" class="sub-menu-link">
                  <img src=""></img>
                  <h5>action</h5>
                  <span>&gt;</span>
                </a>
                <hr></hr>
                <span></span>
                <a href="/notes/notification" class="sub-menu-link">
                  <img src=""></img>
                  <h5>notification</h5>
                  <span>&gt;</span>
                </a>
              </div>
            </div>

            <span className="navbar-text">
              <div className="social-icon">
                <a onClick={() => window.open(process.env.REACT_APP_WEDAA_GITHUB, '_blank')}>
                  <img src={navIcon2} alt="" />
                </a>
              </div>
            </span>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </Router>
  );
};
