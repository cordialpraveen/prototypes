import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { NavBar } from './components/NavBar';
import { Banner } from './components/Banner';
import DocsPage from './components/Docs';
import SwaggerUI from 'swagger-ui-react';
import 'swagger-ui-react/swagger-ui.css';
import NotesList from './components/notes/NotesList';

function App() {
  return (
    <div className="App">
      <NavBar />
      <Router>
        <Routes>
          <Route path="/" element={<Banner />} />
          <Route
            path="/docs"
            element={
              <div className="container">
                <DocsPage />
              </div>
            }
          />
          <Route
            path="/swagger/action"
            element={
              <div className="swagger">
                <SwaggerUI url={process.env.REACT_APP_MICROSERVICE_ACTION.concat('/v3/api-docs')} />
              </div>
            }
          />
          <Route
            path="/swagger/notification"
            element={
              <div className="swagger">
                <SwaggerUI url={process.env.REACT_APP_MICROSERVICE_NOTIFICATION.concat('/v3/api-docs')} />
              </div>
            }
          />
          <Route
            path="/notes/action"
            element={
              <div className="component">
                <NotesList notesApp={'action'} />
              </div>
            }
          />
          <Route
            path="/notes/notification"
            element={
              <div className="component">
                <NotesList notesApp={'notification'} />
              </div>
            }
          />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
