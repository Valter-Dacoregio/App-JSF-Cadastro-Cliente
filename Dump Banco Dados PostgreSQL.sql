--
-- PostgreSQL database dump
--

-- Dumped from database version 12.6 (Ubuntu 12.6-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.6 (Ubuntu 12.6-0ubuntu0.20.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: pessoa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoa (
    tipo character varying(1) NOT NULL,
    id integer NOT NULL,
    cpf character varying(255),
    data_nascimento timestamp without time zone,
    email character varying(255),
    nome character varying(255),
    telefone character varying(255),
    cnpj character varying(255),
    nome_fantasia character varying(255),
    razao_social character varying(255),
    site character varying(255)
);


ALTER TABLE public.pessoa OWNER TO postgres;

--
-- Name: pessoa_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pessoa_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pessoa_id_seq OWNER TO postgres;

--
-- Name: pessoa_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pessoa_id_seq OWNED BY public.pessoa.id;


--
-- Name: pessoajuridicaentity_telefones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pessoajuridicaentity_telefones (
    pessoajuridicaentity_id integer NOT NULL,
    telefones character varying(255)
);


ALTER TABLE public.pessoajuridicaentity_telefones OWNER TO postgres;

--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id character varying(255) NOT NULL,
    login text,
    senha text
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Name: pessoa id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa ALTER COLUMN id SET DEFAULT nextval('public.pessoa_id_seq'::regclass);


--
-- Data for Name: pessoa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pessoa (tipo, id, cpf, data_nascimento, email, nome, telefone, cnpj, nome_fantasia, razao_social, site) FROM stdin;
F	9	12345678901	1900-01-01 00:00:00	valtermdacoregio@gmail.com	Valter Marciano Dacoregio	(99)99999-9999	\N	\N	\N	\N
J	10	\N	\N	\N	\N	\N	123456789001-1	Nome Fantasia	Razão Social	empresa.com.br
\.


--
-- Data for Name: pessoajuridicaentity_telefones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pessoajuridicaentity_telefones (pessoajuridicaentity_id, telefones) FROM stdin;
10	(99)99999-9999
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id, login, senha) FROM stdin;
1	admin	123456
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: pessoa_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pessoa_id_seq', 10, true);


--
-- Name: pessoa pessoa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoa
    ADD CONSTRAINT pessoa_pkey PRIMARY KEY (id);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- Name: pessoajuridicaentity_telefones fk3xrvyhprx3a5pbprqedjxpkev; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pessoajuridicaentity_telefones
    ADD CONSTRAINT fk3xrvyhprx3a5pbprqedjxpkev FOREIGN KEY (pessoajuridicaentity_id) REFERENCES public.pessoa(id);


--
-- PostgreSQL database dump complete
--
