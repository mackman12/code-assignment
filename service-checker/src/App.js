import React, { Component } from 'react'
import Services from './components/Services'
import Header from './components/Header'
import ServiceAdd from './components/ServiceAdd'

class App extends Component {

	state = {
		services: []
	}

	componentDidMount() {
		fetch('http://localhost:8080/service/get')
			.then(res => res.json())
			.then((data) => {
				this.setState({ services: data })
			})
			.catch(console.log)
	}

	render() {
		return (
			<div>
				<Header />
				<ServiceAdd/>
				<Services services={this.state.services} />
			</div>
		)
	}
}

export default App